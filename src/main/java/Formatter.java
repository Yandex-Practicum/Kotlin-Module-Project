public class Formatter {

    String formatValue(double price) {
        double roundedValue = Math.floor(price);
        if (roundedValue == 1) {
            return "рубль";
        } else if (roundedValue >= 2 && roundedValue <= 4) {
            return "рубля";
        } else {
            return "рублей";
        }
    }

    String roundResult(final double result) {
        return String.format("%.2f", result);
    }
}
