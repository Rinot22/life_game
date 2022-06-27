public enum Status {
    NONE,   // 1
    BORN,   // 2
    LIVE,   // 1
    DEAD;   // 2

    public Status stepOne(int around) {
        switch (this) {
            case NONE:
                return (around == 3) ? BORN : NONE;
            case LIVE:
                return (around < 1 || around > 4) ? DEAD : LIVE;
            default:
                return this;
        }
    }

    public Status stepTwo () {
        switch (this) {
            case BORN:
                return LIVE;
            case DEAD:
                return NONE;
            default:
                return this;
        }
    }

    public boolean isCell() {
        return this == LIVE || this == DEAD;
    }
}
