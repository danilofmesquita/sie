package br.iesb.sie.dto;

import java.util.List;

public class FrequenciaDTO {

    public List<String> ticks;
    public List<List<Long>> bars;

    public List<String> getTicks() {
        return ticks;
    }

    public void setTicks(List<String> ticks) {
        this.ticks = ticks;
    }

    public List<List<Long>> getBars() {
        return bars;
    }

    public void setBars(List<List<Long>> bars) {
        this.bars = bars;
    }
}
