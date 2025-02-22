package com.postal.office.mapper;

public interface Mapper<Input, Output> {
    Output perform(Input input);
}
