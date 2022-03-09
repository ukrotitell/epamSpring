package org.epam.testbean;

import lombok.Data;
import org.epam.annotation.InjectRandomInt;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
public class TestStudent {
    @InjectRandomInt(min = 1, max = 10)
    private List<Integer> marks;

}
