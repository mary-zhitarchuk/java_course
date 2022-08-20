package serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SerializeTime implements Serializable {

    private Date creationDate;
    private Date serializationDate;
    private transient Date timeOfDeserialize;

    public SerializeTime() {
        this.creationDate = new Date();
    }

    private void writeObject(ObjectOutputStream out) throws IOException, InterruptedException {
        Thread.sleep(1000);
        setSerializationDate(new Date());
        out.defaultWriteObject();
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException, InterruptedException {
        Thread.sleep(2000);
        in.defaultReadObject();
        setTimeOfDeserialize(new Date());
    }


    public String getDateInSimpleFormat(Date date) {
        if (date != null) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
            return formatter.format(date);
        } else {
            return null;
        }
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getSerializationDate() {
        return serializationDate;
    }

    public void setSerializationDate(Date serializationDate) {
        this.serializationDate = serializationDate;
    }

    public Date getTimeOfDeserialize() {
        return timeOfDeserialize;
    }

    public void setTimeOfDeserialize(Date timeOfDeserialize) {
        this.timeOfDeserialize = timeOfDeserialize;
    }

    @Override
    public String toString() {
        return "SerializeTime{" +
                "creationDate=" + getDateInSimpleFormat(creationDate) +
                ", serializationDate=" + getDateInSimpleFormat(serializationDate) +
                ", timeOfDeserialize=" + getDateInSimpleFormat(timeOfDeserialize) +
                '}';
    }
}