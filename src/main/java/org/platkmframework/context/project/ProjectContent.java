/**
 * ****************************************************************************
 *  Copyright(c) 2025 the original author Eduardo Iglesias Taylor.
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  	 https://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *
 *  Contributors:
 *  	Eduardo Iglesias Taylor - initial API and implementation
 * *****************************************************************************
 */
package org.platkmframework.context.project;

import java.util.Map;
import java.util.Properties;

import org.apache.commons.lang3.StringUtils;
import org.platkmframework.context.exception.ContentException;

/**
 *   Author:
 *     Eduardo Iglesias
 *   Contributors:
 *   	Eduardo Iglesias - initial API and implementation
 * this class should be usefull for webservers o ms applications
 */
public class ProjectContent {

    /**
     * Attribute C_DEFAULT_PROTOCOL
     */
    private static final String C_DEFAULT_PROTOCOL = "http";

    /**
     * Attribute C_DEFAULT_SERVERNAME
     */
    private static final String C_DEFAULT_SERVERNAME = "localhost";

    /**
     * Attribute projectContent
     */
    private static ProjectContent projectContent;

    /**
     * Attribute appProperties
     */
    Properties appProperties;
    
    /**
     * Attribute alreadySet
     */
    boolean alreadySet = false;

    /**
     * Constructor ProjectContent
     */
    private ProjectContent() {
        appProperties = new Properties();
        appProperties.put(CorePropertyConstant.ORG_PLATKMFRAMEWORK_SERVER_PROTOCOL, C_DEFAULT_PROTOCOL);
        appProperties.put(CorePropertyConstant.ORG_PLATKMFRAMEWORK_SERVER_APPNAME, C_DEFAULT_SERVERNAME);
    }

    /**
     * instance
     * @return ProjectContent
     */
    public static ProjectContent instance() {
        if (projectContent == null)
            projectContent = new ProjectContent();
        return projectContent;
    }

    /**
     * projectName
     * @param projectName projectName
     * @return ProjectContent
     */
    protected ProjectContent projectName(String projectName) {
        appProperties.put(CorePropertyConstant.ORG_PLATKMFRAMEWORK_SERVER_APPNAME, projectName);
        return this;
    }

    /**
     * protocol
     * @param protocol protocol
     * @return ProjectContent
     */
    protected ProjectContent protocol(String protocol) {
        appProperties.put(CorePropertyConstant.ORG_PLATKMFRAMEWORK_SERVER_PROTOCOL, protocol);
        return this;
    }

    /**
     * server
     * @param server server
     * @return ProjectContent
     */
    protected ProjectContent server(String server) {
        appProperties.put(CorePropertyConstant.ORG_PLATKMFRAMEWORK_SERVER_NAME, server);
        return this;
    }

    /**
     * port
     * @param port port
     * @return ProjectContent
     */
    protected ProjectContent port(String port) {
        appProperties.put(CorePropertyConstant.ORG_PLATKMFRAMEWORK_SERVER_PORT, port);
        return this;
    }

    /**
     * webSocketPort
     * @param port port
     * @return ProjectContent
     */
    protected ProjectContent webSocketPort(String port) {
        appProperties.put(ContentPropertiesConstant.ORG_PLATKMFRAMEWORK_WEBSOKET_SERVER_PORT, port);
        return this;
    }

    /**
     * contentPath
     * @param contentPath contentPath
     * @return ProjectContent
     */
    protected ProjectContent contentPath(String contentPath) {
        appProperties.put(CorePropertyConstant.ORG_PLATKMFRAMEWORK_CONTENT_PATH, contentPath);
        return this;
    }

    /**
     * servletPath
     * @param servletPath servletPath
     * @return ProjectContent
     */
    protected ProjectContent servletPath(String servletPath) {
        appProperties.put(CorePropertyConstant.ORG_PLATKMFRAMEWORK_SERVLET_PLATH, servletPath);
        return this;
    }

    /**
     * publicPath
     * @param publicPath publicPath
     * @return ProjectContent
     */
    protected ProjectContent publicPath(String publicPath) {
        appProperties.put(CorePropertyConstant.ORG_PLATKMFRAMEWORK_SERVER_PUBLIC_PATH, publicPath);
        return this;
    }

    /**
     * stopKey
     * @param stopKey stopKey
     * @return ProjectContent
     */
    protected ProjectContent stopKey(String stopKey) {
        appProperties.put(CorePropertyConstant.ORG_PLATKMFRAMEWORK_SERVER_STOPKEY, stopKey);
        return this;
    }

    /**
     * corsOrigin
     * @param origin origin
     * @return ProjectContent
     */
    protected ProjectContent corsOrigin(String origin) {
        appProperties.put(CorePropertyConstant.System_Access_Control_Allow_Origin, origin);
        return this;
    }

    /**
     * corsMethod
     * @param methods methods
     * @return ProjectContent
     */
    protected ProjectContent corsMethod(String methods) {
        appProperties.put(CorePropertyConstant.System_Access_Control_Allow_Methods, methods);
        return this;
    }

    /**
     * corsHeader
     * @param header header
     * @return ProjectContent
     */
    protected ProjectContent corsHeader(String header) {
        appProperties.put(CorePropertyConstant.System_Access_Control_Allow_Headers, header);
        return this;
    }

    /**
     * IvD
     * @param packages packages
     * @return ProjectContent
     */
    protected ProjectContent IvD(String packages) {
        appProperties.put(ContentPropertiesConstant.ORG_PLATKMFRAMEWORK_CONFIGURATION_PACKAGE_PREFIX, packages);
        return this;
    }
    

    /**
     * datetimeFormat
     * @param format format
     * @return ProjectContent
     */
    protected ProjectContent datetimeFormat(String format) {
        appProperties.put(ContentPropertiesConstant.ORG_PLATKMFRAMEWORK_FORMAT_DATETIME, format);
        return this;
    }

    /**
     * dateFormat
     * @param format format
     * @return ProjectContent
     */
    protected ProjectContent dateFormat(String format) {
        appProperties.put(ContentPropertiesConstant.ORG_PLATKMFRAMEWORK_FORMAT_DATE, format);
        return this;
    }

    /**
     * timeFormat
     * @param format format
     * @return ProjectContent
     */
    protected ProjectContent timeFormat(String format) {
        appProperties.put(ContentPropertiesConstant.ORG_PLATKMFRAMEWORK_FORMAT_TIME, format);
        return this;
    }
    
    /**
     * add
     * @param key key
     * @param obj obj
     * @return ProjectContent
     */
    protected ProjectContent add(String key, Object obj) {
        appProperties.put(key, obj);
        return this;
    }
 
    
    /**
     * getAppProperties
     * @return Properties
     */
    protected Properties getAppProperties() {
        return appProperties;
    }
    
    /**
     * addProperty
     * @param key key
     * @param value value
     * @return ProjectContent
     */
    protected ProjectContent addProperty(String key, String value) {
        getAppProperties().put(key, value);
        return this;
    }
    


    /**
     * getDateTimeFormat
     * @return String
     */
    public String getDateTimeFormat() {
        return appProperties.getOrDefault(ContentPropertiesConstant.ORG_PLATKMFRAMEWORK_FORMAT_DATETIME, ContentPropertiesConstant.ORG_PLATKMFRAMEWORK_JDBC_FORMAT_DATE_TIME_DEFAULT).toString();
    }

    /**
     * getDateFormat
     * @return String
     */
    public String getDateFormat() {
        return appProperties.getOrDefault(ContentPropertiesConstant.ORG_PLATKMFRAMEWORK_FORMAT_DATE, ContentPropertiesConstant.ORG_PLATKMFRAMEWORK_JDBC_FORMAT_DATE_DEFAULT).toString();
    }

    /**
     * getTimeFormat
     * @return String
     */
    public String getTimeFormat() {
        return appProperties.getOrDefault(ContentPropertiesConstant.ORG_PLATKMFRAMEWORK_FORMAT_TIME, ContentPropertiesConstant.ORG_PLATKMFRAMEWORK_JDBC_FORMAT_TIME_DEFAULT).toString();
    }

    /**
     * getProjectName
     * @return String
     */
    public String getProjectName() {
        return appProperties.getOrDefault(CorePropertyConstant.ORG_PLATKMFRAMEWORK_SERVER_APPNAME, "").toString();
    }

    /**
     * get
     * @param key key
     * @return Object
     */
    public Object get(String key) {
        return appProperties.get(key);
    }

    /**
     * parseValue
     * @param value value
     * @return String
     */
    public String parseValue(String value) {
        if (StringUtils.isBlank(value))
            return null;
        for (Map.Entry<Object, Object> e : appProperties.entrySet()) {
            value = value.replace("${" + e.getKey().toString() + "}", e.getValue().toString());
        }
        return value;
    }

    /**
     * getProperty
     * @param key key
     * @return String
     */
    public String getProperty(String key) {
        return appProperties.getProperty(key, "");
    }
    
    /**
     * getProperty
     * @param key key
     * @return String
     */
    public String getProperty(String key, String defaultValue) {
        return appProperties.getProperty(key, defaultValue);
    }
    
    /**
     * getPropertiesWithPrefix
     * @param prefix prefix
     * @return Properties
     */
    public Properties getPropertiesWithPrefix(String prefix) {
        return  getAppProperties().stringPropertyNames().stream()
                .filter(key -> key.startsWith(prefix))
                .collect(
                    Properties::new,
                    (properties, key) -> properties.setProperty(key, getAppProperties().getProperty(key)),
                    Properties::putAll
                );
    }
    
    /**
     * putProperties
     * @param properties properties
     */
    public void putProperties(Properties properties) {
    	if(alreadySet) throw new ContentException("trying set properties out of context");
    	if(properties != null) {
    		appProperties.putAll(properties);
    	}
    	this.alreadySet = true;
    }
}
