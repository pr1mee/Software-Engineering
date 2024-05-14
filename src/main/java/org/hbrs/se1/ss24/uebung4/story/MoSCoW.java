package org.hbrs.se1.ss24.uebung4.story;

public enum MoSCoW {
    M,//must have
    S,//should have
    C,//could have
    W, EMPTY;//won't have

    public static MoSCoW morph(char prio) {
        return switch (prio) {
            case 'M' -> M;
            case 'S' -> S;
            case 'C' -> C;
            case 'W' -> W;
            default -> throw new IllegalArgumentException("Unrecognized moscow prio: " + prio);
        };
    }
}
