package br.iesb.sie.dto;

import java.util.List;

public class GraficoBarrasDTO {

    public List<String> ticks;
    public List<List<Object>> bars;

    public List<String> getTicks() {
        return ticks;
    }

    public void setTicks(List<String> ticks) {
        this.ticks = ticks;
    }

    public List<List<Object>> getBars() {
        return bars;
    }

    public void setBars(List<List<Object>> bars) {
        this.bars = bars;
    }
}
