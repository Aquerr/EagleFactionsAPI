package io.github.aquerr.eaglefactions.api.config;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

public interface Configuration
{
    Path getConfigDirectoryPath();
    Path getConfigPath();

    ChatConfig getChatConfig();
    DynmapConfig getDynmapConfig();
    FactionsConfig getFactionsConfig();
    PowerConfig getPowerConfig();
    ProtectionConfig getProtectionConfig();
    PVPLoggerConfig getPvpLoggerConfig();
    StorageConfig getStorageConfig();

    BluemapConfig getBluemapConfig();

    HomeConfig getHomeConfig();

    VersionConfig getVersionConfig();

    LangConfig getLangConfig();

    void save();

    void reloadConfiguration() throws IOException;

    int getInt(int defaultValue, Object... nodePath);
    double getDouble(double defaultValue, Object... nodePath);
    float getFloat(float defaultValue, Object... nodePath);
    boolean getBoolean(boolean defaultValue, Object... nodePath);
    String getString(String defaultValue, Object... nodePath);

    List<String> getListOfStrings(List<String> defaultValue, Object... nodePath);
    Set<String> getSetOfStrings(Set<String> defaultValue, Object... nodePath);

    <T> List<T> getGenericList(Class<T> clazz, List<T> defaultValue, Object... nodePath);

    <T> T getGenericType(Class<T> clazz, T defaultValue, Object... nodePath);
}
