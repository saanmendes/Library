package com.library.controllers.dtos;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.List;

public class BookDTO {

        private Long id;

        @NotNull(message = "O título do livro é obrigatório.")
        private String title;

        private String description;

        @Size(max = 5, message = "Um livro pode ter no máximo 5 autores.")
        private List<Long> authorIds;

        public BookDTO() {
        }

        public Long getId() {
                return id;
        }

        public void setId(Long id) {
                this.id = id;
        }

        public @NotNull(message = "O título do livro é obrigatório.") String getTitle() {
                return title;
        }

        public void setTitle(@NotNull(message = "O título do livro é obrigatório.") String title) {
                this.title = title;
        }

        public String getDescription() {
                return description;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public @Size(max = 5, message = "Um livro pode ter no máximo 5 autores.") List<Long> getAuthorIds() {
                return authorIds;
        }

        public void setAuthorIds(@Size(max = 5, message = "Um livro pode ter no máximo 5 autores.") List<Long> authorIds) {
                this.authorIds = authorIds;
        }
}


