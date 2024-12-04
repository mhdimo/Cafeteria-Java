package factories;

import models.Cup;

public class CupFactory {
    public static Cup createCup(String size) {
        
        switch (size.toLowerCase()) {
            case "normal":
                return new Cup("normal");
            case "grande":
                return new Cup("grande");
            case "venti":
                return new Cup("venti");
            default:
                throw new IllegalArgumentException("Invalid cup size: " + size);
        }
    }
}
