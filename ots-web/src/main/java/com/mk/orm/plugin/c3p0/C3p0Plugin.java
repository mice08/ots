/**
 * Copyright (c) 2014-2015, 上海乐住信息技术有限公司(http://www.imike.com).
 */
package com.mk.orm.plugin.c3p0;

import java.beans.PropertyVetoException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mk.orm.kit.StrKit;
import com.mk.orm.plugin.IPlugin;
import com.mk.orm.plugin.bean.IDataSourceProvider;

/**
 * C3p0数据源连接池
 * @author IT Group of imike beijing(aiqing.chu@imike.com).
 *
 */
public class C3p0Plugin implements IPlugin, IDataSourceProvider {
    
    private String jdbcUrl;
    private String user;
    private String password;
    private String driverClass = "com.mysql.jdbc.Driver";
    private int maxPoolSize = 100;
    private int minPoolSize = 10;
    private int initialPoolSize = 10;
    private int maxIdleTime = 20;
    private int acquireIncrement = 2;
    
    private ComboPooledDataSource dataSource;
    
    public C3p0Plugin setDriverClass(String driverClass) {
        if (StrKit.isBlank(driverClass))
            throw new IllegalArgumentException("driverClass can not be blank.");
        this.driverClass = driverClass;
        return this;
    }
    
    public C3p0Plugin setMaxPoolSize(int maxPoolSize) {
        if (maxPoolSize < 1)
            throw new IllegalArgumentException("maxPoolSize must more than 0.");
        this.maxPoolSize = maxPoolSize;
        return this;
    }
    
    public C3p0Plugin setMinPoolSize(int minPoolSize) {
        if (minPoolSize < 1)
            throw new IllegalArgumentException("minPoolSize must more than 0.");
        this.minPoolSize = minPoolSize;
        return this;
    }
    
    public C3p0Plugin setInitialPoolSize(int initialPoolSize) {
        if (initialPoolSize < 1)
            throw new IllegalArgumentException("initialPoolSize must more than 0.");
        this.initialPoolSize = initialPoolSize;
        return this;
    }
    
    public C3p0Plugin setMaxIdleTime(int maxIdleTime) {
        if (maxIdleTime < 1)
            throw new IllegalArgumentException("maxIdleTime must more than 0.");
        this.maxIdleTime = maxIdleTime;
        return this;
    }
    
    public C3p0Plugin setAcquireIncrement(int acquireIncrement) {
        if (acquireIncrement < 1)
            throw new IllegalArgumentException("acquireIncrement must more than 0.");
        this.acquireIncrement = acquireIncrement;
        return this;
    }
    
    public C3p0Plugin(String jdbcUrl, String user, String password) {
        this.jdbcUrl = jdbcUrl;
        this.user = user;
        this.password = password;
    }
    
    public C3p0Plugin(String jdbcUrl, String user, String password, String driverClass) {
        this.jdbcUrl = jdbcUrl;
        this.user = user;
        this.password = password;
        this.driverClass = driverClass != null ? driverClass : this.driverClass;
    }
    
    public C3p0Plugin(String jdbcUrl, String user, String password, String driverClass, Integer maxPoolSize, Integer minPoolSize, Integer initialPoolSize, Integer maxIdleTime, Integer acquireIncrement) {
        initC3p0Properties(jdbcUrl, user, password, driverClass, maxPoolSize, minPoolSize, initialPoolSize, maxIdleTime, acquireIncrement);
    }
    
    private void initC3p0Properties(String jdbcUrl, String user, String password, String driverClass, Integer maxPoolSize, Integer minPoolSize, Integer initialPoolSize, Integer maxIdleTime, Integer acquireIncrement) {
        this.jdbcUrl = jdbcUrl;
        this.user = user;
        this.password = password;
        this.driverClass = driverClass != null ? driverClass : this.driverClass;
        this.maxPoolSize = maxPoolSize != null ? maxPoolSize : this.maxPoolSize;
        this.minPoolSize = minPoolSize != null ? minPoolSize : this.minPoolSize;
        this.initialPoolSize = initialPoolSize != null ? initialPoolSize : this.initialPoolSize;
        this.maxIdleTime = maxIdleTime != null ? maxIdleTime : this.maxIdleTime;
        this.acquireIncrement = acquireIncrement != null ? acquireIncrement : this.acquireIncrement;
    }
    
    public C3p0Plugin(File propertyfile) {
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(propertyfile);
            Properties ps = new Properties();
            ps.load(fis);
            
            initC3p0Properties(ps.getProperty("jdbcUrl"), ps.getProperty("user"), ps.getProperty("password"), ps.getProperty("driverClass"),
                    toInt(ps.getProperty("maxPoolSize")), toInt(ps.getProperty("minPoolSize")), toInt(ps.getProperty("initialPoolSize")),
                    toInt(ps.getProperty("maxIdleTime")),toInt(ps.getProperty("acquireIncrement")));
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (fis != null)
                try {fis.close();} catch (IOException e) {e.printStackTrace();}
        }
    }
    
    public C3p0Plugin(Properties properties) {
        Properties ps = properties;
        initC3p0Properties(ps.getProperty("jdbcUrl"), ps.getProperty("user"), ps.getProperty("password"), ps.getProperty("driverClass"),
                toInt(ps.getProperty("maxPoolSize")), toInt(ps.getProperty("minPoolSize")), toInt(ps.getProperty("initialPoolSize")),
                toInt(ps.getProperty("maxIdleTime")),toInt(ps.getProperty("acquireIncrement")));
    }
    
    public boolean start() {
        dataSource = new ComboPooledDataSource();
        dataSource.setJdbcUrl(jdbcUrl);
        dataSource.setUser(user);
        dataSource.setPassword(password);
        try {dataSource.setDriverClass(driverClass);}
        catch (PropertyVetoException e) {dataSource = null; System.err.println("C3p0Plugin start error"); throw new RuntimeException(e);} 
        dataSource.setMaxPoolSize(maxPoolSize);
        dataSource.setMinPoolSize(minPoolSize);
        dataSource.setInitialPoolSize(initialPoolSize);
        dataSource.setMaxIdleTime(maxIdleTime);
        dataSource.setAcquireIncrement(acquireIncrement);
        
        return true;
    }
    
    private Integer toInt(String str) {
        return Integer.parseInt(str);
    }
    
    public DataSource getDataSource() {
        return dataSource;
    }
    
    public boolean stop() {
        if (dataSource != null)
            dataSource.close();
        return true;
    }
}
