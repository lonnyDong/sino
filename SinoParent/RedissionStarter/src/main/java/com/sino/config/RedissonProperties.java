package com.sino.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "spring.redisson")
public class RedissonProperties {

	ConfigFile configFile = new ConfigFile();
	
	public class ConfigFile {
		/** json格式配置文件 */
		private String json;
		/** yaml格式配置文件 */
		private String yaml;
		/** properties */
		private String properties;

		public String getJson() {
			return json;
		}

		public void setJson(String json) {
			this.json = json;
		}

		public String getYaml() {
			return yaml;
		}

		public void setYaml(String yaml) {
			this.yaml = yaml;
		}

		public String getProperties() {
			return properties;
		}

		public void setProperties(String properties) {
			this.properties = properties;
		}

	}

	public ConfigFile getConfigFile() {
		return configFile;
	}

	public void setConfigFile(ConfigFile configFile) {
		this.configFile = configFile;
	}
	
	
	
}
