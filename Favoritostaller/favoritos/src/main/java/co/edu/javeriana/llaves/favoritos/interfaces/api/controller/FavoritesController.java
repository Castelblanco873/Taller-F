package co.edu.javeriana.llaves.favoritos.interfaces.api.controller;

import co.edu.javeriana.llaves.favoritos.gateways.dtos.FavoritesDTO;
import co.edu.javeriana.llaves.favoritos.gateways.service.FavoritesFacade;
import co.edu.javeriana.llaves.favoritos.core.use_cases.ValidateFavoriteKeyUseCase;
import co.edu.javeriana.llaves.favoritos.core.use_cases.EditFavoriteKeyAlias;
import co.edu.javeriana.llaves.favoritos.core.use_cases.GetFavorites;
import co.edu.javeriana.llaves.favoritos.core.use_cases.DeleteFavoriteKeyUseCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/favorites")
public class FavoritesController {

    private final static Logger log = Logger.getLogger(FavoritesController.class.getName());

    private final FavoritesFacade favoritesFacade;
    private final ValidateFavoriteKeyUseCase validateFavoriteKeyUseCase;
    private final DeleteFavoriteKeyUseCase deleteFavoriteKeyUseCase;
    private final EditFavoriteKeyAlias editFavoriteKeyAlias;
    private final GetFavorites getFavorites;

    @Autowired
    public FavoritesController(FavoritesFacade favoritesFacade,
                               ValidateFavoriteKeyUseCase validateFavoriteKeyUseCase,
                               DeleteFavoriteKeyUseCase deleteFavoriteKeyUseCase,
                               EditFavoriteKeyAlias editFavoriteKeyAlias,
                               GetFavorites getFavorites) {
        this.favoritesFacade = favoritesFacade;
        this.validateFavoriteKeyUseCase = validateFavoriteKeyUseCase;
        this.deleteFavoriteKeyUseCase = deleteFavoriteKeyUseCase;
        this.editFavoriteKeyAlias = editFavoriteKeyAlias;
        this.getFavorites = getFavorites;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFavorite(@PathVariable String id) {
        boolean deleted = deleteFavoriteKeyUseCase.delete(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateFavoriteKey(
            @RequestParam String keyText,
            @RequestParam String user) {

        log.log(Level.INFO, "validateFavoriteKey called for keyText: " + keyText + " and user: " + user);
        boolean isValid = validateFavoriteKeyUseCase.execute(keyText, user);
        return ResponseEntity.ok(isValid);
    }

    // Agrega aquí otros endpoints si los necesitas
}
