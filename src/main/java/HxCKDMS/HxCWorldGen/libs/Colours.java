package HxCKDMS.HxCWorldGen.libs;

public class Colours {
    public static int[] oreColour(int meta) {
        int[] colours;
        switch (meta) {
            case 1 : colours = new int[]{250, 250, 250}; break;
            case 2 : colours = new int[]{200, 240, 255}; break;
            case 3 : colours = new int[]{160, 150, 160}; break;
            case 4 : colours = new int[]{200, 200, 152}; break;
            case 5 : colours = new int[]{240, 255, 255}; break;
            case 6 : colours = new int[]{210, 250, 255}; break;
            case 7 : colours = new int[]{133, 95, 90}; break;
            case 8 : colours = new int[]{160, 250, 255}; break;
            case 9 : colours = new int[]{0, 160, 120}; break;
            case 10 : colours = new int[]{200, 10, 10}; break;
            case 11 : colours = new int[]{30, 120, 200}; break;
            case 12 : colours = new int[]{100, 56, 18}; break;
            case 13 : colours = new int[]{70, 40, 60}; break;
            default : colours = new int[]{174, 105, 41}; break;
        }
        return colours;
    }
    public static int[] blockColour(int meta) {
        int[] colours;
        switch (meta) {
            case 1 : colours = new int[]{250, 250, 250}; break;
            case 2 : colours = new int[]{200, 240, 255}; break;
            case 3 : colours = new int[]{160, 150, 160}; break;
            case 4 : colours = new int[]{200, 200, 152}; break;
            case 5 : colours = new int[]{240, 255, 255}; break;
            case 6 : colours = new int[]{210, 250, 255}; break;
            case 7 : colours = new int[]{160, 200, 210}; break;
            case 8 : colours = new int[]{160, 250, 255}; break;
            case 9 : colours = new int[]{0, 160, 120}; break;
            case 10 : colours = new int[]{200, 10, 10}; break;
            case 11 : colours = new int[]{30, 120, 200}; break;
            case 12 : colours = new int[]{100, 56, 18}; break;
            case 13 : colours = new int[]{100, 200, 250}; break;
            default : colours = new int[]{174, 105, 41}; break;
        }
        return colours;
    }
    public static int[] resourceColour(int meta) {
        int[] colours;
        switch (meta) {
            case 1 : colours = new int[]{250, 250, 250}; break;
            case 2 : colours = new int[]{200, 240, 255}; break;
            case 3 : colours = new int[]{160, 150, 160}; break;
            case 4 : colours = new int[]{200, 200, 152}; break;
            case 5 : colours = new int[]{240, 255, 255}; break;
            case 6 : colours = new int[]{210, 250, 255}; break;
            case 7 : colours = new int[]{133, 95, 90}; break;
            case 8 : colours = new int[]{160, 250, 255}; break;
            case 9 : colours = new int[]{0, 160, 120}; break;
            case 10 : colours = new int[]{200, 10, 10}; break;
            case 11 : colours = new int[]{30, 120, 200}; break;
            case 12 : colours = new int[]{100, 56, 18}; break;
            case 13 : colours = new int[]{190, 170, 140}; break;
            default : colours = new int[]{174, 105, 41}; break;
        }
        return colours;
    }
}
