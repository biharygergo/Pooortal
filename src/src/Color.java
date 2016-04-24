package src;

/**
 * Color enum used by the Bullet and SpecialWall classes
 */
public enum Color {
    Blue,
    Yellow,
    Red,
    Green,
    Empty;

    public Color next() {
        return values()[ordinal() + 1];
    }
}