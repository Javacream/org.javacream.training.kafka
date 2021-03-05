package org.javacream.training.kafka;

public class Configuration {

	public enum BootstrapServers {
		LOCAL("localhost:9092"), REMOTE("10.28.4.41:9092");

		private String servers;

		public String getServers() {
			return servers;
		}

		BootstrapServers(String servers) {
			this.servers = servers;
		}
	}
}
