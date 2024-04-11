package starlight.backend.talent.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

import java.time.LocalDate;
import java.util.List;

@Builder
public record TalentUpdateRequest(
        @NotBlank
        @Length(min = 3, max = 64)
        @Pattern(regexp = "^[A-Za-z\\s'-]+$", message = "must not contain special characters")
        String fullName,

        @NotBlank
        @Length(min = 10, max = 10)
        @Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)\\S+$", message = "The date must be in the format: yyyy-MM-dd")
        LocalDate birthday,
        @URL
        String avatar,

        String education,

        String experience,

        List<String> positions
) {
}
