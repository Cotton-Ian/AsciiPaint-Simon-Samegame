package esi.g55019.atl.asciipaint.DPComposite;

import esi.g55019.atl.asciipaint.Shape;

abstract class Component implements Shape{
    Shape shape;

    public Component(Shape shape){
        this.shape = shape;
    }

}