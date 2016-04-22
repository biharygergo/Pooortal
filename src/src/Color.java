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
        //TODO írjuk hozza a doksihoz?
        // No bounds checking required here, because the last instance overrides
        return values()[ordinal() + 1];
    }
}