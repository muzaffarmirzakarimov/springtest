package Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PC {
    private int code;
    private String model;
    private int speed;
    private int ram;
    private int hd;
    private String cd;
    private double price;
}
