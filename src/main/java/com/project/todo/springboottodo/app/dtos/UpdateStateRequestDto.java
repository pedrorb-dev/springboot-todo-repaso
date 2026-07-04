package com.project.todo.springboottodo.app.dtos;

import com.project.todo.springboottodo.app.utils.StateEnum;

public class UpdateStateRequestDto {
    private StateEnum state;

    public UpdateStateRequestDto() {
    }

    public UpdateStateRequestDto(StateEnum state) {
        this.state = state;
    }

    public StateEnum getState() {
        return state;
    }

    public void setState(StateEnum state) {
        this.state = state;
    }
}
