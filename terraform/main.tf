terraform {
  required_version = ">= 0.14.0"
  required_providers {
    openstack = {
      source  = "terraform-provider-openstack/openstack"
      version = "~> 1.53.0"
    }
  }
}

provider "openstack" {
  auth_url = "https://cloud.crplab.ru:5000"
  tenant_id = "a02aed7892fa45d0bc2bef3b8a08a6e9"
  tenant_name = "students"
  user_domain_name = "Default"
  user_name = "master2022"
  password = var.passwd
  region = "RegionOne"
}

# Define security group
resource "openstack_networking_secgroup_v2" "buldakova_secgroup" {
  name        = "buldakova_secgroup"
  description = "Security group for ssh and http/https"
}

resource "openstack_networking_secgroup_rule_v2" "default_rule" {
  direction         = "ingress"
  ethertype         = "IPv4"
  protocol          = "tcp"
  port_range_min    = 1
  port_range_max    = 20000
  remote_ip_prefix  = "0.0.0.0/0"
  security_group_id = openstack_networking_secgroup_v2.buldakova_secgroup.id
}

resource "openstack_compute_instance_v2" "movie_bot" {
  name        = "movie_bot"
  image_name  = var.image_name
  flavor_name = var.flavor_name
  key_pair    = var.key_pair
  security_groups = [openstack_networking_secgroup_v2.buldakova_secgroup.name]

  network {
    name = var.network_name
  }
}
