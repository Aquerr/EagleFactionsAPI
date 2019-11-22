package io.github.aquerr.eaglefactions.api.config;

public interface StorageConfig
{
	void reload();

	String getStorageType();

	String getStorageUsername();

	String getStoragePassword();

	String getDatabaseUrl();

	String getDatabaseName();
}
