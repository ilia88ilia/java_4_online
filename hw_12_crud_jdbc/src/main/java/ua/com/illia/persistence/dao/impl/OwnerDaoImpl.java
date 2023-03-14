package ua.com.illia.persistence.dao.impl;

import ua.com.illia.annotations.BeanClass;
import ua.com.illia.annotations.InjectBean;
import ua.com.illia.persistence.config.JdbcService;
import ua.com.illia.persistence.dao.OwnerDao;
import ua.com.illia.persistence.entity.Owner;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@BeanClass
public class OwnerDaoImpl implements OwnerDao {

    @InjectBean
    private JdbcService jdbcService;

    private static final String CREATE_OWNER = "insert into owners values (default, ?, ?, ?, ?, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP())";
    private static final String UPDATE_OWNER = "update owners set first_name = ?, last_name = ?, email = ?, phone = ?, updated = CURRENT_TIMESTAMP() where id = ?";
    private static final String DELETE_OWNER = "delete from owners where id = ?";
    private static final String FIND_OWNER_BY_ID = "select * from owners where id = ";
    private static final String FIND_OWNERS = "select * from owners";
    private static final String ADD_PET_TO_OWNER = "insert into pet_own values (?, ?)";
    private static final String FIND_ALL_OWNERS_BY_PET = "select id, first_name, last_name, email, phone, created, updated from owners left join pet_own on owners.id = pet_own.own_id where pet_id = ";
    private static final String DELETE_OWNER_FROM_PET = "delete from pet_own where pet_id = ? and own_id = ?";
    private static final String DELETE_FROM_ALL_PETS = "delete from pet_own where own_id = ?";

    @Override
    public void create(Owner entity) {
        try (PreparedStatement preparedStatement = jdbcService.getConnection().prepareStatement(CREATE_OWNER)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getPhone());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public void update(Owner entity, Long id) {
        try (PreparedStatement preparedStatement = jdbcService.getConnection().prepareStatement(UPDATE_OWNER)) {
            preparedStatement.setString(1, entity.getFirstName());
            preparedStatement.setString(2, entity.getLastName());
            preparedStatement.setString(3, entity.getEmail());
            preparedStatement.setString(4, entity.getPhone());
            preparedStatement.setLong(5, entity.getId());
            preparedStatement.executeUpdate(); //Фиксация изменений
            System.out.println();
            System.out.println("Updated Successfully");
            System.out.println(findById(id));
            System.out.println();
        } catch (SQLException e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public void delete(Long id) {
        try (PreparedStatement preparedStatement = jdbcService.getConnection().prepareStatement(DELETE_FROM_ALL_PETS)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
        try (PreparedStatement preparedStatement = jdbcService.getConnection().prepareStatement(DELETE_OWNER)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public Optional<Owner> findById(Long id) {
        try (ResultSet resultSet = jdbcService.getStatement().executeQuery(FIND_OWNER_BY_ID + id)) {
            while (resultSet.next()) {
                return Optional.of(generateOwnerByResultSet(resultSet));
            }
        } catch (Exception e) {
            return Optional.empty();
        }
        return Optional.empty();
    }

    @Override
    public Collection<Owner> findAll() {
        List<Owner> owners = new ArrayList<>();
        try (ResultSet resultSet = jdbcService.getStatement().executeQuery(FIND_OWNERS)) {
            while (resultSet.next()) {
                owners.add(generateOwnerByResultSet(resultSet));
            }
        } catch (SQLException e) {
            return owners;
        }
        return owners;
    }

    @Override
    public void addPetToOwner(Long petId, Long ownerId) {
        try (PreparedStatement preparedStatement = jdbcService.getConnection().prepareStatement(ADD_PET_TO_OWNER)) {
            preparedStatement.setLong(1, petId);
            preparedStatement.setLong(2, ownerId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println("e = " + e);
        }
    }

    @Override
    public Collection<Owner> findByPet(Long petId) {
        List<Owner> owners = new ArrayList<>();
        try (ResultSet resultSet = jdbcService.getStatement().executeQuery(FIND_ALL_OWNERS_BY_PET + petId)) {
            while (resultSet.next()) {
                owners.add(generateOwnerByResultSet(resultSet));
            }
        } catch (SQLException e) {
            return owners;
        }
        return owners;
    }

    @Override
    public void deleteOwnerFromPet(Long petId, Long ownerId) {
        try (PreparedStatement preparedStatement = jdbcService.getConnection().prepareStatement(DELETE_OWNER_FROM_PET)) {
            preparedStatement.setLong(1, petId);
            preparedStatement.setLong(2, ownerId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("e = " + e);
        }
    }


    private Owner generateOwnerByResultSet(ResultSet resultSet) throws SQLException {
        Long id = resultSet.getLong("id");
        String firstName = resultSet.getString("first_name");
        String lastName = resultSet.getString("last_name");
        String email = resultSet.getString("email");
        String phone = resultSet.getString("phone");
        Timestamp created = resultSet.getTimestamp("created");
        Timestamp updated = resultSet.getTimestamp("updated");
        Owner owner = new Owner();
        owner.setId(id);
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        owner.setEmail(email);
        owner.setPhone(phone);
        owner.setCreated(created);
        owner.setUpdated(updated);
        return owner;
    }
}
