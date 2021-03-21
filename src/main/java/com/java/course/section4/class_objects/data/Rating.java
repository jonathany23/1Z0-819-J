package com.java.course.section4.class_objects.data;

public enum Rating {
    //instancias de Rating
    //todas son consideradas public static final
    //Al ser  instancias el texto entre parentesis debe ser inicializado a traves del constructor
    //por ello necesita:
    NO_RATED("\u2606\u2606\u2606\u2606\u2606"),
    ONE_STAR("\u2605\u2606\u2606\u2606\u2606"),
    TWO_STAR("\u2605\u2605\u2606\u2606\u2606"),
    THREE_STAR("\u2605\u2605\u2605\u2606\u2606"),
    FOUR_STAR("\u2605\u2605\u2605\u2605\u2606"),
    FIVE_STAR("\u2605\u2605\u2605\u2605\u2605");

    // 1: Un atributo donde almacene el valor enviado como referencia
    private String star;

    // 2: Constructor a traves del cual se inicializan las variables
    private Rating(String star){
        this.star = star;
    }

    // 3: Un metodo get para recuperar su valor desde donde se invoque
    public String getStart(){
        return this.star;
    }
}
