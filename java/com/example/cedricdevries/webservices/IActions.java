package com.example.cedricdevries.webservices;

import java.util.List;

public interface IActions {
    void actionResponseData(List<ArcheologicalElement> data);

    void actionErrorResponse(Throwable t) throws Throwable;
}
