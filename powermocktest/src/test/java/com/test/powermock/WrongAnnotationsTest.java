package com.test.powermock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import javax.sql.DataSource;

@RunWith(PowerMockRunner.class)
@PrepareForTest(WrongAnnotationsTest.JdbcTemplate.class)
public class WrongAnnotationsTest {
    public static class SimpleQueryExecutorTasklet {

        private DataSource dataSource;
        private String sql;

        public void setDataSource(DataSource dataSource) {
            this.dataSource = dataSource;
        }

        public void setSql(String sql) {
            this.sql = sql;
        }


        public void execute() throws Exception {
            new JdbcTemplate(this.dataSource).execute(this.sql);
        }
    }


    public static class JdbcTemplate {
        private DataSource dataSource;

        public JdbcTemplate(DataSource dataSource) {
            this.dataSource = dataSource;
        }


        public void execute(String sql) {
            System.out.println(dataSource);
            System.out.println(sql);
        }
    }


    @InjectMocks
    SimpleQueryExecutorTasklet simpleQueryExecutorTasklet;

    @Mock
    JdbcTemplate jdbcTemplate;

    @Mock
    DataSource dataSource;

    String sql="select * from abc;";

    @Before
    public void setUp() throws Exception {
        simpleQueryExecutorTasklet.setDataSource(dataSource);
        simpleQueryExecutorTasklet.setSql(sql);
        PowerMockito.whenNew(JdbcTemplate.class).withAnyArguments().thenReturn(jdbcTemplate);
    }

//    @Test(expected = NullPointerException.class)
//    public void testExecute() throws Exception {
//        simpleQueryExecutorTasklet.execute();
//    }

    @Test
    public void testExecute_noException() throws Exception {
        Mockito.doNothing().when(jdbcTemplate).execute(Mockito.any(String.class));
        simpleQueryExecutorTasklet.execute();
        // Here will write some assertions
    }
}

