package com.example.demo;

import java.io.Serializable;

public class Clock2 extends Clock implements Time, Serializable {
    protected int sec;

    Clock2() {
        super();
        sec = 0;
    }

    public Clock2(String ma, int c, int h, int m, int s, int i) {
        super(ma, c, h, m, i);
        sec = s;
    }

    @Override
    public String toGet_Type() {
        return "HMS";
    }
    @Override
    public int toGet_Sec() {
        return sec;
    }

    @Override
    public void toSet(TYPES type, int h) throws TimeExcept {
        if (type == TYPES.HOUR) {
            if (h >= 24) {
                throw new TimeExcept("ERROR: Диапазон часов от 0 до 23, исправьте");
            } else {
                hour = h;
            }
        } else if (type == TYPES.MIN) {
            if (h >= 60) {
                throw new TimeExcept("ERROR: Диапазон минут от 0 до 59, исправьте");
            } else {
                min = h;
            }
        } else if (type == TYPES.SEC) {
            if (h >= 60) {
                throw new TimeExcept("ERROR: Диапазон секунд от 0 до 59, исправьте");
            } else {
                sec = h;
            }
        } else throw new TimeExcept("Заданное время не соотвествует истине");
    }

    @Override
    public void toMove(TYPES type, int h) throws TimeExcept {
        if (type == TYPES.HOUR) {
            if (h >= 24) throw new TimeExcept("ERROR: Диапазон часов от 0 до 23, исправьте");
            else hour += h;
        } else if (type == TYPES.MIN) {
            if (h >= 60) throw new TimeExcept("ERROR: Диапазон минут от 0 до 59, исправьте");
            else min += h;
        } else if (type == TYPES.SEC) {
            if (h >= 60) throw new TimeExcept("ERROR: Диапазон секунд от 0 до 59, исправьте");
            else sec += h;
        } else throw new TimeExcept("Заданное время не соотвествует истине");
    }



    @Override
    public String toGet_Time() {return String.format("%02d:%02d:%02d", hour, min, sec); }
}
