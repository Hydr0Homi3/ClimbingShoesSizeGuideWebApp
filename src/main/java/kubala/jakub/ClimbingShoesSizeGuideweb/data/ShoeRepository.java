package kubala.jakub.ClimbingShoesSizeGuideweb.data;

//repository for shoe which extends CrudRepository from spring data

import kubala.jakub.ClimbingShoesSizeGuideweb.biz.model.Shoe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository                     //this annotation creates repository with full CRUD capabilities. @Repository tells spring that this interface is treated as an actual data repository
public interface ShoeRepository extends CrudRepository<Shoe, Long> {    //@CrudRepository <Type of the domain model class to be responsible for, Data type of the ID property of the Shoes class>

}
