package calendar;

import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import com.sun.javafx.scene.control.skin.ComboBoxPopupControl;
import com.sun.javafx.scene.control.skin.DatePickerContent;
import com.sun.javafx.scene.control.skin.DatePickerSkin;

/**
 * 
 * @author Rima
 * @author Johannes Brautzsch
 * @reference http://stackoverflow.com/questions/20369447/datepicker-in-javafx-8
 *
 */

public class DateTimePickerSkin extends DatePickerSkin {

    private DateTimePicker datePicker;
    private DatePickerContent ret;

    public DateTimePickerSkin(DateTimePicker datePicker){
        super(datePicker);
        this.datePicker = datePicker;
    }

    @Override 
    public Node getPopupContent() {
        if (ret == null){
            ret = (DatePickerContent) super.getPopupContent();

            Slider time = new Slider(0, 1439, (datePicker.getTimeValue() != null ? (datePicker.getTimeValue().getMinute() + 60*datePicker.getTimeValue().getHour()) : 0));
            
            Label timeValueLabel = new Label((datePicker.getTimeValue() != null ? (String.format("%02d", datePicker.getTimeValue().getHour()) + ":" + String.format("%02d", datePicker.getTimeValue().getMinute()) + " "): " "));

            HBox hbox = new HBox();
            hbox.setHgrow(time, Priority.ALWAYS);
            hbox.setAlignment(Pos.CENTER);
            time.setStyle("-fx-padding: 8;");
            time.setMaxWidth(Double.MAX_VALUE);
            timeValueLabel.setStyle("-fx-padding: 8;");
            hbox.setStyle("-fx-font-size: 12pt; -fx-text-fill: #d8d8d8;");
            
            hbox.getChildren().addAll(time,timeValueLabel);
            ret.getChildren().addAll(hbox);

            time.valueProperty().addListener((observable, oldValue, newValue) -> {
                datePicker.setTimeValue(datePicker.getTimeValue().withHour(newValue.intValue() / 60));
                datePicker.setTimeValue(datePicker.getTimeValue().withMinute(newValue.intValue() % 60));
                
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd'.'MM'.'yyyy' 'HH:mm");
                datePicker.getEditor().setText(datePicker.getDateTimeValue().format(formatter));
                timeValueLabel.setText((datePicker.getTimeValue() != null ? (String.format("%02d", datePicker.getTimeValue().getHour()) + ":" + String.format("%02d", datePicker.getTimeValue().getMinute()) + " "): " "));
            });

        }
        return ret;
    }


}