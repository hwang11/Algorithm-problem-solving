package han;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.sql.Timestamp;

public class time {
	LocalDateTime st = new Timestamp(System.currentTimeMillis()).toLocalDateTime();
	System.out.print(st);
}

 

