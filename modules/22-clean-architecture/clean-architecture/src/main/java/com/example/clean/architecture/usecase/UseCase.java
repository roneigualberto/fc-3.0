package com.example.clean.architecture.usecase;

public interface UseCase<IN, OUT> {

    OUT execute(IN input);

}
