output "servers" {
  value = {
    movie_bot = openstack_compute_instance_v2.movie_bot.access_ip_v4
  }
}
