package helper;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;

public class OperationResultMessage {

    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public OperationResultMessage(String status, String message) {
        this.status = status;
        this.message = message;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OperationResultMessage)) return false;

        OperationResultMessage that = (OperationResultMessage) o;

        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return !(message != null ? !message.equals(that.message) : that.message != null);

    }

    @Override
    public int hashCode() {
        int result = status != null ? status.hashCode() : 0;
        result = 31 * result + (message != null ? message.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("message", message)
                .add("status", status)
                .toString();
    }
}
