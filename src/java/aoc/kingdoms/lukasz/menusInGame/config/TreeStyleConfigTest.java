package aoc.kingdoms.lukasz.menusInGame.config;

/**
 * Test class for TreeStyleConfigManager
 * This class can be used to verify that the configuration manager is working correctly
 */
public class TreeStyleConfigTest {
    
    public static void testConfigManager() {
        System.out.println("=== TreeStyleConfigManager Test ===");
        
        try {
            // Get the configuration manager instance
            TreeStyleConfigManager configManager = TreeStyleConfigManager.getInstance();
            
            // Test Mission Tree configuration
            TreeStyleConfigManager.MissionTreeConfig missionConfig = configManager.getMissionTreeConfig();
            System.out.println("Mission Tree Configuration:");
            System.out.println("  - Use Vertical Style: " + missionConfig.useVerticalStyle);
            System.out.println("  - Outline Width: " + missionConfig.connectionOutlineWidth);
            System.out.println("  - Inner Width: " + missionConfig.connectionInnerWidth);
            System.out.println("  - Join Type: " + missionConfig.connectionJoinType);
            System.out.println("  - Outline Color: " + colorToString(missionConfig.connectionOutlineColor));
            System.out.println("  - Unlocked Color: " + colorToString(missionConfig.connectionUnlockedColor));
            System.out.println("  - Locked Color: " + colorToString(missionConfig.connectionLockedColor));
            System.out.println("  Visual Effects:");
            System.out.println("    - Wave Effect: " + missionConfig.enableWaveEffect + " (Intensity: " + missionConfig.waveEffectIntensity + ")");
            System.out.println("    - Gradient Background: " + missionConfig.enableGradientBackground + " (Opacity: " + missionConfig.gradientOpacity + ")");
            System.out.println("    - Sparks Animation: " + missionConfig.enableSparksAnimation + " (Opacity: " + missionConfig.sparksOpacity + ")");
            System.out.println("    - Background Shader: " + missionConfig.enableBackgroundShader + " (Opacity: " + missionConfig.backgroundShaderOpacity + ")");
            System.out.println("    - Clip View: " + missionConfig.enableClipView);
            
            // Test Technology Tree configuration
            TreeStyleConfigManager.TechnologyTreeConfig techConfig = configManager.getTechnologyTreeConfig();
            System.out.println("\nTechnology Tree Configuration:");
            System.out.println("  - Use Vertical Style: " + techConfig.useVerticalStyle);
            System.out.println("  - Outline Width: " + techConfig.connectionOutlineWidth);
            System.out.println("  - Inner Width: " + techConfig.connectionInnerWidth);
            System.out.println("  - Join Type: " + techConfig.connectionJoinType);
            System.out.println("  - Outline Color: " + colorToString(techConfig.connectionOutlineColor));
            System.out.println("  - Unlocked Color: " + colorToString(techConfig.connectionUnlockedColor));
            System.out.println("  - Locked Color: " + colorToString(techConfig.connectionLockedColor));
            System.out.println("  Visual Effects:");
            System.out.println("    - Wave Effect: " + techConfig.enableWaveEffect + " (Intensity: " + techConfig.waveEffectIntensity + ")");
            System.out.println("    - Gradient Background: " + techConfig.enableGradientBackground + " (Opacity: " + techConfig.gradientOpacity + ")");
            System.out.println("    - Sparks Animation: " + techConfig.enableSparksAnimation + " (Opacity: " + techConfig.sparksOpacity + ")");
            System.out.println("    - Background Shader: " + techConfig.enableBackgroundShader + " (Opacity: " + techConfig.backgroundShaderOpacity + ")");
            System.out.println("    - Clip View: " + techConfig.enableClipView);
            System.out.println("    - Map Background: " + techConfig.enableMapBackground + " (Opacity: " + techConfig.mapBackgroundOpacity + ")");
            
            // Test reload functionality
            System.out.println("\nTesting configuration reload...");
            configManager.reloadConfigurations();
            System.out.println("Configuration reloaded successfully!");
            
            System.out.println("\n=== Test Completed Successfully ===");
            
        } catch (Exception e) {
            System.err.println("Error during configuration test: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Helper method to convert Color to readable string
     */
    private static String colorToString(com.badlogic.gdx.graphics.Color color) {
        if (color == null) {
            return "null";
        }
        return String.format("RGBA(%.2f, %.2f, %.2f, %.2f)", color.r, color.g, color.b, color.a);
    }
    
    /**
     * Main method for standalone testing
     */
    public static void main(String[] args) {
        testConfigManager();
    }
}
