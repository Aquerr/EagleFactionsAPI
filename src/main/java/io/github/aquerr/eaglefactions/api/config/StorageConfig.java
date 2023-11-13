package io.github.aquerr.eaglefactions.api.config;

public interface StorageConfig extends ConfigReloadable
{
	String getStorageType();

	String getStorageUsername();

	String getStoragePassword();

	String getDatabaseUrl();

	String getDatabaseName();
}
