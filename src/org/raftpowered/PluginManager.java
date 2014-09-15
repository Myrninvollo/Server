package org.raftpowered;

import java.io.*;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.*;

public class PluginManager {
	public static List<Plugin> plugins = new ArrayList<Plugin>();
	public static int pluginCount = 0;
	
	@SuppressWarnings("deprecation") // just url->uri. will change later
	public static void init() {
		Raft.onEnable();
		
		if(!new File("plugins").exists()) new File("plugins").mkdirs();
		
		for(File file : new File("plugins").listFiles()) {
			if(file.getName().endsWith(".jar")) {
				boolean stop = false;
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				ZipInputStream in = null;
				try {
					in = new ZipInputStream(new FileInputStream(file));
					ZipEntry entry;
					while((entry = in.getNextEntry()) != null) {
						if(entry.getName().equalsIgnoreCase("main.txt")) {
							byte[] buffer = new byte[1024];
							int length;
							while((length = in.read(buffer)) > 0) out.write(buffer, 0, length);
						}
					}
				} catch(Exception e) {
					stop = true;
				} finally {
					try { if(in != null) in.close(); } catch (Exception e) {}
					try { out.close(); } catch (Exception e) {}
				}
				if(!stop) {
					String main = new String(out.toByteArray());
					try {
						addUrl(file.toURL());
						Class<?> cl = Class.forName(main);
						Object instance = cl.getConstructor().newInstance();
						pluginCount++;
						if(!(instance instanceof Plugin)) {
							Raft.logWarning("Main class should extend 'Plugin'! Starting anyway... " +
								file.getName().substring(0, file.getName().length() - 4));
						}
						else {
							Raft.logInfo("Enabling " + ((Plugin) instance).getName() + " (" + ((Plugin) instance).getVersion() + ")...");
							plugins.add((Plugin) instance);
							((Plugin) instance).onEnable();
						}
					} catch (Throwable e) {
						stop = true;
					}
					
				}
				if(stop)
					Raft.logWarning("Failed to load plugin! " +
						file.getName().substring(0, file.getName().length() - 4));
			}
		}
	}
	
	private static void addUrl(URL url) throws Throwable {
		URLClassLoader loader = (URLClassLoader) ClassLoader.getSystemClassLoader();
		Class<URLClassLoader> system = URLClassLoader.class;
		Method method = system.getDeclaredMethod("addURL", URL.class);
		method.setAccessible(true);
		method.invoke(loader, url);
	}
}
