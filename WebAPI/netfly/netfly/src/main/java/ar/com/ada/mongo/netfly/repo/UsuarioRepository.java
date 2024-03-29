package ar.com.ada.mongo.netfly.repo;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ar.com.ada.mongo.netfly.entities.*;

/**
 * UsuarioRepository
 */
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, ObjectId> {
    
    Usuario findBy_id(ObjectId _id);    
    Usuario findByUserName(String userName);
    Usuario findByUserEmail(String email);

}
