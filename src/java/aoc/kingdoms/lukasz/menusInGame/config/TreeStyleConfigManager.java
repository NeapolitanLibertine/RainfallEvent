package aoc.kingdoms.lukasz.menusInGame.config;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import space.earlygrey.shapedrawer.JoinType;

/**
 * Unified configuration manager for Mission Tree and Technology Tree styles
 * Handles loading and managing configuration from JSON files
 */
public class TreeStyleConfigManager {
    
    // Singleton instance
    private static TreeStyleConfigManager instance;
    
    // Mission Tree Configuration
    public static class MissionTreeConfig {
        // Connection line configuration
        public float connectionOutlineWidth = 4.0F;
        public float connectionInnerWidth = 2.0F;
        public Color connectionOutlineColor = new Color(0.0F, 0.0F, 0.0F, 0.7F);
        public Color connectionUnlockedColor = new Color(0.8F, 0.7F, 0.3F, 1.0F);
        public Color connectionLockedColor = new Color(0.25F, 0.25F, 0.25F, 0.8F);
        public JoinType connectionJoinType = JoinType.POINTY;
        public boolean useVerticalStyle = true;

        // Visual effects configuration
        public boolean enableWaveEffect = true;           // Enable water wave shader effect
        public boolean enableGradientBackground = true;   // Enable gradient background rendering
        public boolean enableSparksAnimation = true;      // Enable sparks animation at bottom
        public boolean enableBackgroundShader = true;     // Enable background shader effects
        public boolean enableClipView = true;             // Enable clip view rendering
        public boolean enableFixedBackground = false;     // Enable fixed background image instead of dynamic effects

        // Fixed background configuration
        public String fixedBackgroundPath = "ui/loading/background_M.png";  // Path to fixed background image
        public float fixedBackgroundOpacity = 1.0F;       // Fixed background opacity (0.0-1.0)
        public boolean fixedBackgroundCentered = true;    // Whether to center the fixed background
        public boolean fixedBackgroundScaled = true;      // Whether to scale the fixed background to fit

        // Effect intensity configuration
        public float waveEffectIntensity = 1.0F;          // Wave effect intensity (0.0-2.0)
        public float gradientOpacity = 0.6F;              // Gradient background opacity (0.0-1.0)
        public float sparksOpacity = 0.15F;               // Sparks animation opacity (0.0-1.0)
        public float backgroundShaderOpacity = 0.25F;     // Background shader opacity (0.0-1.0)
    }
    
    // Technology Tree Configuration
    public static class TechnologyTreeConfig {
        // Connection line configuration
        public float connectionOutlineWidth = 4.0F;
        public float connectionInnerWidth = 2.0F;
        public Color connectionOutlineColor = new Color(0.0F, 0.0F, 0.0F, 0.7F);
        public Color connectionUnlockedColor = new Color(0.8F, 0.7F, 0.3F, 1.0F);
        public Color connectionLockedColor = new Color(0.25F, 0.25F, 0.25F, 0.8F);
        public JoinType connectionJoinType = JoinType.POINTY;
        public boolean useVerticalStyle = true;

        // Visual effects configuration
        public boolean enableWaveEffect = true;           // Enable water wave shader effect
        public boolean enableGradientBackground = true;   // Enable gradient background rendering
        public boolean enableSparksAnimation = true;      // Enable sparks animation at bottom
        public boolean enableBackgroundShader = true;     // Enable background shader effects
        public boolean enableClipView = true;             // Enable clip view rendering
        public boolean enableMapBackground = true;        // Enable map background rendering

        // Effect intensity configuration
        public float waveEffectIntensity = 1.0F;          // Wave effect intensity (0.0-2.0)
        public float gradientOpacity = 0.6F;              // Gradient background opacity (0.0-1.0)
        public float sparksOpacity = 0.15F;               // Sparks animation opacity (0.0-1.0)
        public float backgroundShaderOpacity = 0.25F;     // Background shader opacity (0.0-1.0)
        public float mapBackgroundOpacity = 0.15F;        // Map background opacity (0.0-1.0)
    }
    
    // Configuration instances
    private MissionTreeConfig missionTreeConfig;
    private TechnologyTreeConfig technologyTreeConfig;
    
    // Configuration file path
    private static final String CONFIG_FILE_PATH = "rainfall/rfEvent_M.json";
    
    // Private constructor for singleton
    private TreeStyleConfigManager() {
        missionTreeConfig = new MissionTreeConfig();
        technologyTreeConfig = new TechnologyTreeConfig();
        loadConfigurations();
    }
    
    /**
     * Get singleton instance
     */
    public static TreeStyleConfigManager getInstance() {
        if (instance == null) {
            instance = new TreeStyleConfigManager();
        }
        return instance;
    }
    
    /**
     * Get Mission Tree configuration
     */
    public MissionTreeConfig getMissionTreeConfig() {
        return missionTreeConfig;
    }
    
    /**
     * Get Technology Tree configuration
     */
    public TechnologyTreeConfig getTechnologyTreeConfig() {
        return technologyTreeConfig;
    }
    
    /**
     * Load all configurations from JSON file
     */
    public void loadConfigurations() {
        try {
            FileHandle fileHandle = com.badlogic.gdx.Gdx.files.internal(CONFIG_FILE_PATH);
            if (fileHandle.exists()) {
                JsonReader jsonReader = new JsonReader();
                JsonValue configFileJson = jsonReader.parse(fileHandle);
                
                // Load Mission Tree configuration
                loadMissionTreeConfig(configFileJson);
                
                // Load Technology Tree configuration
                loadTechnologyTreeConfig(configFileJson);
                
                System.out.println("TreeStyleConfigManager: Successfully loaded configurations from " + CONFIG_FILE_PATH);
            } else {
                System.out.println("TreeStyleConfigManager: Configuration file not found, using default values.");
            }
        } catch (Exception e) {
            System.err.println("TreeStyleConfigManager: Unable to load configurations from " + CONFIG_FILE_PATH + ", using default values. Error: " + e.getMessage());
        }
    }
    
    /**
     * Load Mission Tree specific configuration
     */
    private void loadMissionTreeConfig(JsonValue configFileJson) {
        // Read whether to use vertical mission tree configuration
        if (configFileJson.has("useVerticalMissionTree")) {
            missionTreeConfig.useVerticalStyle = configFileJson.getBoolean("useVerticalMissionTree", true);
        }

        // Read visual effects configuration
        loadVisualEffectsConfig(configFileJson, missionTreeConfig, "missionTreeEffects");

        // Read connection line configuration
        JsonValue connectionConfig = configFileJson.get("connectionStyle");
        if (connectionConfig != null) {
            loadConnectionStyleConfig(connectionConfig, missionTreeConfig);
        }
    }
    
    /**
     * Load Technology Tree specific configuration
     */
    private void loadTechnologyTreeConfig(JsonValue configFileJson) {
        // Read whether to use vertical technology tree configuration
        if (configFileJson.has("useVerticalTechnologyTree")) {
            technologyTreeConfig.useVerticalStyle = configFileJson.getBoolean("useVerticalTechnologyTree", true);
        }

        // Read visual effects configuration
        loadVisualEffectsConfig(configFileJson, technologyTreeConfig, "technologyTreeEffects");

        // Read technology tree connection line configuration
        JsonValue techConnectionConfig = configFileJson.get("technologyConnectionStyle");
        if (techConnectionConfig != null) {
            loadConnectionStyleConfig(techConnectionConfig, technologyTreeConfig);
        }
    }
    
    /**
     * Load visual effects configuration for Mission Tree or Technology Tree
     */
    private void loadVisualEffectsConfig(JsonValue configFileJson, Object config, String effectsKey) {
        JsonValue effectsConfig = configFileJson.get(effectsKey);
        if (effectsConfig == null) {
            // Try to load from global effects configuration
            effectsConfig = configFileJson.get("visualEffects");
        }

        if (effectsConfig != null) {
            boolean isMissionTree = config instanceof MissionTreeConfig;
            MissionTreeConfig mConfig = isMissionTree ? (MissionTreeConfig) config : null;
            TechnologyTreeConfig tConfig = !isMissionTree ? (TechnologyTreeConfig) config : null;

            // Load effect enable/disable switches
            if (effectsConfig.has("enableWaveEffect")) {
                boolean enableWave = effectsConfig.getBoolean("enableWaveEffect", true);
                if (isMissionTree) {
                    mConfig.enableWaveEffect = enableWave;
                } else {
                    tConfig.enableWaveEffect = enableWave;
                }
            }

            if (effectsConfig.has("enableGradientBackground")) {
                boolean enableGradient = effectsConfig.getBoolean("enableGradientBackground", true);
                if (isMissionTree) {
                    mConfig.enableGradientBackground = enableGradient;
                } else {
                    tConfig.enableGradientBackground = enableGradient;
                }
            }

            if (effectsConfig.has("enableSparksAnimation")) {
                boolean enableSparks = effectsConfig.getBoolean("enableSparksAnimation", true);
                if (isMissionTree) {
                    mConfig.enableSparksAnimation = enableSparks;
                } else {
                    tConfig.enableSparksAnimation = enableSparks;
                }
            }

            if (effectsConfig.has("enableBackgroundShader")) {
                boolean enableBgShader = effectsConfig.getBoolean("enableBackgroundShader", true);
                if (isMissionTree) {
                    mConfig.enableBackgroundShader = enableBgShader;
                } else {
                    tConfig.enableBackgroundShader = enableBgShader;
                }
            }

            if (effectsConfig.has("enableClipView")) {
                boolean enableClip = effectsConfig.getBoolean("enableClipView", true);
                if (isMissionTree) {
                    mConfig.enableClipView = enableClip;
                } else {
                    tConfig.enableClipView = enableClip;
                }
            }

            // Technology tree specific effects
            if (!isMissionTree && effectsConfig.has("enableMapBackground")) {
                tConfig.enableMapBackground = effectsConfig.getBoolean("enableMapBackground", true);
            }

            // Fixed background configuration (Mission Tree only)
            if (isMissionTree && effectsConfig.has("enableFixedBackground")) {
                mConfig.enableFixedBackground = effectsConfig.getBoolean("enableFixedBackground", false);
            }

            if (isMissionTree && effectsConfig.has("fixedBackgroundPath")) {
                mConfig.fixedBackgroundPath = effectsConfig.getString("fixedBackgroundPath", "ui/loading/background_M.png");
            }

            if (isMissionTree && effectsConfig.has("fixedBackgroundOpacity")) {
                mConfig.fixedBackgroundOpacity = effectsConfig.getFloat("fixedBackgroundOpacity", 1.0F);
            }

            if (isMissionTree && effectsConfig.has("fixedBackgroundCentered")) {
                mConfig.fixedBackgroundCentered = effectsConfig.getBoolean("fixedBackgroundCentered", true);
            }

            if (isMissionTree && effectsConfig.has("fixedBackgroundScaled")) {
                mConfig.fixedBackgroundScaled = effectsConfig.getBoolean("fixedBackgroundScaled", true);
            }

            // Load effect intensity configuration
            if (effectsConfig.has("waveEffectIntensity")) {
                float intensity = effectsConfig.getFloat("waveEffectIntensity", 1.0F);
                if (isMissionTree) {
                    mConfig.waveEffectIntensity = intensity;
                } else {
                    tConfig.waveEffectIntensity = intensity;
                }
            }

            if (effectsConfig.has("gradientOpacity")) {
                float opacity = effectsConfig.getFloat("gradientOpacity", 0.6F);
                if (isMissionTree) {
                    mConfig.gradientOpacity = opacity;
                } else {
                    tConfig.gradientOpacity = opacity;
                }
            }

            if (effectsConfig.has("sparksOpacity")) {
                float opacity = effectsConfig.getFloat("sparksOpacity", 0.15F);
                if (isMissionTree) {
                    mConfig.sparksOpacity = opacity;
                } else {
                    tConfig.sparksOpacity = opacity;
                }
            }

            if (effectsConfig.has("backgroundShaderOpacity")) {
                float opacity = effectsConfig.getFloat("backgroundShaderOpacity", 0.25F);
                if (isMissionTree) {
                    mConfig.backgroundShaderOpacity = opacity;
                } else {
                    tConfig.backgroundShaderOpacity = opacity;
                }
            }

            // Technology tree specific opacity
            if (!isMissionTree && effectsConfig.has("mapBackgroundOpacity")) {
                tConfig.mapBackgroundOpacity = effectsConfig.getFloat("mapBackgroundOpacity", 0.15F);
            }
        }
    }

    /**
     * Load connection style configuration for either Mission Tree or Technology Tree
     */
    private void loadConnectionStyleConfig(JsonValue connectionConfig, Object config) {
        // Determine which config object we're working with
        boolean isMissionTree = config instanceof MissionTreeConfig;
        MissionTreeConfig mConfig = isMissionTree ? (MissionTreeConfig) config : null;
        TechnologyTreeConfig tConfig = !isMissionTree ? (TechnologyTreeConfig) config : null;
        
        // Read connection line width configuration
        if (connectionConfig.has("outlineWidth")) {
            float outlineWidth = connectionConfig.getFloat("outlineWidth", 4.0F);
            if (isMissionTree) {
                mConfig.connectionOutlineWidth = outlineWidth;
            } else {
                tConfig.connectionOutlineWidth = outlineWidth;
            }
        }
        
        if (connectionConfig.has("innerWidth")) {
            float innerWidth = connectionConfig.getFloat("innerWidth", 2.0F);
            if (isMissionTree) {
                mConfig.connectionInnerWidth = innerWidth;
            } else {
                tConfig.connectionInnerWidth = innerWidth;
            }
        }
        
        // Read connection line color configuration
        if (connectionConfig.has("outlineColor")) {
            Color outlineColor = parseColorFromJson(connectionConfig.get("outlineColor"));
            if (outlineColor != null) {
                if (isMissionTree) {
                    mConfig.connectionOutlineColor = outlineColor;
                } else {
                    tConfig.connectionOutlineColor = outlineColor;
                }
            }
        }
        
        if (connectionConfig.has("unlockedColor")) {
            Color unlockedColor = parseColorFromJson(connectionConfig.get("unlockedColor"));
            if (unlockedColor != null) {
                if (isMissionTree) {
                    mConfig.connectionUnlockedColor = unlockedColor;
                } else {
                    tConfig.connectionUnlockedColor = unlockedColor;
                }
            }
        }
        
        if (connectionConfig.has("lockedColor")) {
            Color lockedColor = parseColorFromJson(connectionConfig.get("lockedColor"));
            if (lockedColor != null) {
                if (isMissionTree) {
                    mConfig.connectionLockedColor = lockedColor;
                } else {
                    tConfig.connectionLockedColor = lockedColor;
                }
            }
        }
        
        // Read connection line join type configuration
        if (connectionConfig.has("joinType")) {
            JoinType joinType = parseJoinTypeFromString(connectionConfig.getString("joinType", "POINTY"));
            if (isMissionTree) {
                mConfig.connectionJoinType = joinType;
            } else {
                tConfig.connectionJoinType = joinType;
            }
        }
    }
    
    /**
     * Parse Color from JSON array
     */
    private Color parseColorFromJson(JsonValue colorJson) {
        if (colorJson != null && colorJson.isArray() && colorJson.size >= 4) {
            return new Color(
                colorJson.get(0).asFloat(),
                colorJson.get(1).asFloat(),
                colorJson.get(2).asFloat(),
                colorJson.get(3).asFloat()
            );
        }
        return null;
    }
    
    /**
     * Parse JoinType from string
     */
    private JoinType parseJoinTypeFromString(String joinTypeStr) {
        String upperJoinType = joinTypeStr.toUpperCase();
        switch (upperJoinType) {
            case "SMOOTH":
                return JoinType.SMOOTH;
            case "NONE":
                return JoinType.NONE;
            case "POINTY":
            default:
                return JoinType.POINTY;
        }
    }
    
    /**
     * Reload configurations from file
     */
    public void reloadConfigurations() {
        loadConfigurations();
    }
}
