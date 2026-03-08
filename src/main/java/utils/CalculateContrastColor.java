package utils;

public class CalculateContrastColor {

    public static double getRelativeLuminance(String rgb) {
        String[] values = rgb.replace("rgba(", "")
                .replace("rgb(", "")
                .replace(")", "")
                .split(",");

        double r = Double.parseDouble(values[0].trim()) / 255;
        double g = Double.parseDouble(values[1].trim()) / 255;
        double b = Double.parseDouble(values[2].trim()) / 255;

        r = (r <= 0.03928) ? r / 12.92 : Math.pow((r + 0.055) / 1.055, 2.4);
        g = (g <= 0.03928) ? g / 12.92 : Math.pow((g + 0.055) / 1.055, 2.4);
        b = (b <= 0.03928) ? b / 12.92 : Math.pow((b + 0.055) / 1.055, 2.4);

        return 0.2126 * r + 0.7152 * g + 0.0722 * b;
    }
}
