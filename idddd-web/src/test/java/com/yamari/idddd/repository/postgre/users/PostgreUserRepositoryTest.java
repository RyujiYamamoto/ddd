package com.yamari.idddd.repository.postgre.users;

import static org.assertj.core.api.Assertions.assertThat;

import com.yamari.idddd.domain.models.users.MailAddress;
import com.yamari.idddd.domain.models.users.User;
import com.yamari.idddd.domain.models.users.UserId;
import com.yamari.idddd.domain.models.users.UserName;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PostgreUserRepositoryTest {

  // ���ؗp�̐ڑ����
  private static String url;
  private static String dbUser;
  private static String password;

  private PostgreUserRepository targetRepository = new PostgreUserRepository();

  /**
   * DB�ڑ�
   */
  @BeforeClass
  public static void setupDb() {
    try {
      Properties dbConfig = new Properties();
      InputStream inputStream =
          PostgreUserRepositoryTest.class.getResourceAsStream("/db.properties");
      dbConfig.load(inputStream);

      url = dbConfig.get("jdbc.url").toString();
      dbUser = dbConfig.get("jdbc.username").toString();
      password = dbConfig.get("jdbc.password").toString();

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * users�e�[�u���̑S���R�[�h�폜
   */
  private void truncateDb() {
    try (Connection conn = DriverManager.getConnection(url, dbUser, password);
        PreparedStatement ps = conn.prepareStatement("TRUNCATE users")) {
      ps.execute();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /**
   * �e�X�g���̃��R�[�h��}��
   */
  private void insertDefaultUser() {
    try (Connection conn = DriverManager.getConnection(url, dbUser, password);
        PreparedStatement ps =
            conn.prepareStatement(
                "INSERT INTO users (id, name, mail_address) VALUES ('000000', 'exists', 'exists@example.com');");) {
      ps.execute();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  /** �e�X�g����DB���R�[�h��ݒ� */
  @Before
  public void setDefaultUsers() {
    truncateDb();
    insertDefaultUser();
  }

  @Test
  public void testFindByUserId_targetingExistingUser() {
    // DB�ɑ��݂��郆�[�U���擾�ł��邩�m�F
    User fetchedUser = targetRepository.find(new UserId("000000"));
    assertThat(fetchedUser.id.getValue()).isEqualTo("000000");
    assertThat(fetchedUser.name.getValue()).isEqualTo("exists");
    assertThat(fetchedUser.mailAddress.getValue()).isEqualTo("exists@example.com");
  }

  @Test
  public void testFindByUserId_targetingAbsentUser() {
    // DB�ɑ��݂��Ȃ����[�U�̏ꍇ�Anull��Ԃ�
    User fetchedUser = targetRepository.find(new UserId("absent"));
    assertThat(fetchedUser).isNull();
  }

  @Test
  public void testFindByUserName_targetingExistingUser() {
    // DB�ɑ��݂��郆�[�U���擾�ł��邩�m�F
    User fetchedUser = targetRepository.find(new UserName("exists"));
    assertThat(fetchedUser.id.getValue()).isEqualTo("000000");
    assertThat(fetchedUser.name.getValue()).isEqualTo("exists");
    assertThat(fetchedUser.mailAddress.getValue()).isEqualTo("exists@example.com");
  }

  @Test
  public void testFindByUserName_targetingAbsentUser() {
    // DB�ɑ��݂��Ȃ����[�U�̏ꍇ�Anull��Ԃ�
    User fetchedUser = targetRepository.find(new UserName("absent"));
    assertThat(fetchedUser).isNull();
  }

  @Test
  public void testSave_targetingAbsentUser() {
    String id = "save";
    String name = "saveUser";
    String address = "save@example.com";
    User saveUser = new User(new UserId(id), new UserName(name), new MailAddress(address));
    targetRepository.save(saveUser);

    // DB�ɑ��݂��Ȃ��̂�INSERT����
    User fetchedUser = targetRepository.find(new UserId(id));

    assertThat(fetchedUser.id.getValue()).isEqualTo(id);
    assertThat(fetchedUser.name.getValue()).isEqualTo(name);
    assertThat(fetchedUser.mailAddress.getValue()).isEqualTo(address);

    // �X�V�O��UserName��find���Ă��擾�ł���
    User fetchedUserByUserNameBeforeUpdate = targetRepository.find(new UserName("exists"));
    assertThat(fetchedUserByUserNameBeforeUpdate).isNotNull();
  }

  @Test
  public void testSave_targetingExistingUser() {
    String id = "000000";
    String name = "saveUser";
    String address = "save@example.com";
    User saveUser = new User(new UserId(id), new UserName(name), new MailAddress(address));
    targetRepository.save(saveUser);

    // DB�ɑ��݂���̂�UPDATE����
    User fetchedUser = targetRepository.find(new UserName("saveUser"));

    assertThat(fetchedUser.id.getValue()).isEqualTo(id);
    assertThat(fetchedUser.name.getValue()).isEqualTo(name);
    assertThat(fetchedUser.mailAddress.getValue()).isEqualTo(address);

    // �X�V�O��UserName��find�����null���Ԃ�
    User fetchedUserByUserNameBeforeUpdate = targetRepository.find(new UserName("exists"));
    assertThat(fetchedUserByUserNameBeforeUpdate).isNull();
  }

  @Test
  public void testDelete() {
    String id = "000000";
    User fetchedUser = targetRepository.find(new UserId(id));
    assertThat(fetchedUser).isNotNull();

    User targetUser =
        new User(new UserId(id), new UserName("test"), new MailAddress("address@example.com"));
    targetRepository.delete(targetUser);

    User fetchedUserAfterDelete = targetRepository.find(new UserId(id));
    assertThat(fetchedUserAfterDelete).isNull();
  }
}
