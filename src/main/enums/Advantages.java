package main.enums;

/**
 * Defines advantages of attacking move type against defending creature type.
 *
 * The following chart shows attack multiplier values for the given attack/defense combination types.
 *
 *          Def  N, F,  W,  E,  G,  I,  F,  P,  G,  F,  P,  B,  R,  G,  D,  D,  S,  F
 * Atk
 * NORMAL        1	1	1	1	1	1	1	1	1	1	1	1	0.5	0	1	1	0.5	1
 * FIRE          1	0.5	0.5	1	2	2	1	1	1	1	1	2	0.5	1	0.5	1	2	1
 * WATER         1	2	0.5	1	0.5	1	1	1	2	1	1	1	2	1	0.5	1	1	1
 * ELECTRIC      1	1	2	0.5	0.5	1	1	1	0	2	1	1	1	1	0.5	1	1	1
 * GRASS         1	0.5	2	1	0.5	1	1	0.5	2	0.5	1	0.5	2	1	0.5	1	0.5	1
 * ICE           1	0.5	0.5	1	2	0.5	1	1	2	2	1	1	1	1	2	1	0.5	1
 * FIGHTING      2	1	1	1	1	2	1	0.5	1	0.5	0.5	0.5	2	0	1	2	2	0.5
 * POISON        1	1	1	1	2	1	1	0.5	0.5	1	1	1	0.5	0.5	1	1	0	2
 * GROUND        1	2	1	2	0.5	1	1	2	1	0	1	0.5	2	1	1	1	2	1
 * FLYING        1	1	1	0.5	2	1	2	1	1	1	1	2	0.5	1	1	1	0.5	1
 * PSYCHIC       1	1	1	1	1	1	2	2	1	1	0.5	1	1	1	1	0	0.5	1
 * BUG           1	0.5	1	1	2	1	0.5	0.5	1	0.5	2	1	1	0.5	1	2	0.5	0.5
 * ROCK          1	2	1	1	1	2	0.5	1	0.5	2	1	2	1	1	1	1	0.5	1
 * GHOST         0	1	1	1	1	1	1	1	1	1	2	1	1	2	1	0.5	1	1
 * DRAGON        1	1	1	1	1	1	1	1	1	1	1	1	1	1	2	1	0.5	0
 * DARK          1	1	1	1	1	1	0.5	1	1	1	2	1	1	2	1	0.5	1	0.5
 * STEEL         1	0.5	0.5	0.5	1	2	1	1	1	1	1	1	2	1	1	1	0.5	2
 * FAIRY         1	0.5	1	1	1	1	2	0.5	1	1	1	1	1	1	2	2	0.5	1
 *
 */

public enum Advantages {
    
}