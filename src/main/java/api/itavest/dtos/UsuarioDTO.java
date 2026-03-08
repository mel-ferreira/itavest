package api.itavest.dtos;


import api.itavest.entidades.Usuario;

public class UsuarioDTO {

    private Long id;
    private String nome;
    private String email;

    public UsuarioDTO(){}

    public UsuarioDTO(Usuario entity)
    {
        id = entity.getId();
        nome = entity.getNome();
        email = entity.getEmail();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}