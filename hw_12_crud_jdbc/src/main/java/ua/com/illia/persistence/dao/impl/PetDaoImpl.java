package ua.com.illia.persistence.dao.impl;

import ua.com.illia.annotations.BeanClass;
import ua.com.illia.annotations.InjectBean;
import ua.com.illia.persistence.config.JdbcService;
import ua.com.illia.persistence.dao.PetDao;
import ua.com.illia.persistence.entity.Pet;
import ua.com.illia.persistence.type.PetType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@BeanClass
public class PetDaoImpl implements PetDao {

    @InjectBean
    private JdbcService jdbcService;
    private static final String CREATE_PET = "insert into pets values (default, ?)";
    private static final String FIND_PET_BY_ID = "select * from pets where id = ";
    private static final String FIND_ALL_PETS = "select * from pets";
    private static final String FIND_ALL_PETS_BY_OWNER = "select id, pet_type from pets right join pet_own on pets.id = pet_own.pet_id where own_id = ";

    @Override
    public void create() {
        PetType[] petTypes = PetType.values();
        for (PetType pt : petTypes) {
            try (PreparedStatement preparedStatement = jdbcService.getConnection().prepareStatement(CREATE_PET)) {
                preparedStatement.setString(1, pt.toString());
                preparedStatement.executeUpdate();
            } catch (SQLException e) {
                System.out.println("e = " + e);
            }
        }
    }

    @Override
    public Optional<Pet> findById(Long id) {
        try (ResultSet resultSet = jdbcService.getStatement().executeQuery(FIND_PET_BY_ID + id)) {
            while (resultSet.next()) {
                return Optional.of(generatePetByResultSet(resultSet));
            }
        } catch (Exception e) {
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public Collection<Pet> findAll() {
        List<Pet> pets = new ArrayList<>();
        try (ResultSet resultSet = jdbcService.getStatement().executeQuery(FIND_ALL_PETS)) {
            while (resultSet.next()) {
                pets.add(generatePetByResultSet(resultSet));
            }
        } catch (SQLException e) {
            return pets;
        }
        return pets;
    }

    @Override
    public Collection<Pet> findByOwner(Long ownerId) {
        List<Pet> pets = new ArrayList<>();
        try (ResultSet resultSet = jdbcService.getStatement().executeQuery(FIND_ALL_PETS_BY_OWNER + ownerId)) {
            while (resultSet.next()) {
                pets.add(generatePetByResultSet(resultSet));
            }
        } catch (SQLException e) {
            return pets;
        }
        return pets;
    }

    private Pet generatePetByResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String type = resultSet.getString("pet_type");
        PetType petType = PetType.valueOf(type);
        Pet pet = new Pet();
        pet.setId(id);
        pet.setPetType(petType);
        return pet;
    }
}
