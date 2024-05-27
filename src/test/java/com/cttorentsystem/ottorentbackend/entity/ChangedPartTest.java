package com.cttorentsystem.ottorentbackend.entity;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ChangedPartTest {

    @Test
    void testChangedPartEntity() {
        // Given
        Long changedPartId = 1L;
        String changedPartName = "Engine Oil Filter";
        String changedPartPrice = "$10";
        String changedPartDescription = "Replacement of the engine oil filter.";

        // When
        ChangedPart changedPart = new ChangedPart(changedPartId, changedPartName, changedPartPrice, changedPartDescription);

        // Then
        assertNotNull(changedPart);
        assertEquals(changedPartId, changedPart.getChangedPartId());
        assertEquals(changedPartName, changedPart.getChangedPartName());
        assertEquals(changedPartPrice, changedPart.getChangedPartPrice());
        assertEquals(changedPartDescription, changedPart.getChangedPartDescription());
    }
}
