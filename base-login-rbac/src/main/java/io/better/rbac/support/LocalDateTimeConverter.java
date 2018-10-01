package io.better.rbac.support;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * @author better create in 2018/10/1 09:37
 */
@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

    /**
     * Converts the value stored in the entity attribute into the
     * data representation to be stored in the database.
     *
     * @param attribute the entity attribute value to be converted
     * @return the converted data to be stored in the database column
     */
    @Override
    public Timestamp convertToDatabaseColumn(LocalDateTime attribute) {
        return Objects.nonNull(attribute) ? Timestamp.valueOf(attribute) : null;
    }

    /**
     * Converts the data stored in the database column into the
     * value to be stored in the entity attribute.
     * Note that it is the responsibility of the converter writer to
     * specify the correct dbData type for the corresponding column
     * for use by the JDBC driver: i.e., persistence providers are
     * not expected to do such type conversion.
     *
     * @param dbData the data from the database column to be converted
     * @return the converted value to be stored in the entity attribute
     */
    @Override
    public LocalDateTime convertToEntityAttribute(Timestamp dbData) {
        return Objects.nonNull(dbData) ? dbData.toLocalDateTime() : null;
    }
}
