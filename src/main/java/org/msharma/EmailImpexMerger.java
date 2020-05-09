package org.msharma;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * @author Mohan Sharma Created on 18/12/17.
 * This Class merges all email impex files for a country to a single file.
 */
public class EmailImpexMerger
{
	public static final String STAGED = "Staged";
	public static final String ONLINE = "Online";
	public static final String EMAIL = "email";

	public static void main(String[] args) throws IOException
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Give me the absolute path to landmarkshopsinitialdata/import/coreData/contentCatalogs");
		final String CORE_DATA_CONTENT_CATALOG_FOLDER_PATH = scanner.nextLine();
		System.out.println("Give me the countryISO for which need to merge emails.");
		String countryIso = scanner.nextLine();
		System.out.println("Give me the output file absolute path");
		String outputImpex = scanner.nextLine();
		Path coreFolder = Paths.get(CORE_DATA_CONTENT_CATALOG_FOLDER_PATH);
		Optional<Path> countryCoreDataOptional  =
				Files
						.list(coreFolder)
						.filter(path -> Files.isDirectory(path))
						.filter(path ->  countryIso.equalsIgnoreCase(path.toFile().getName()))
						.findFirst();
		List<String> allEmailLines = Lists.newArrayList();
		if(countryCoreDataOptional.isPresent())
		{
			Path countryCoreData = countryCoreDataOptional.get();
			allEmailLines =
					Files.list(countryCoreData)
							.map(conceptPath ->
							{
								List<Path> emailsForConcepts = Lists.newArrayList();
								try
								{
									emailsForConcepts =
											Files
													.list(conceptPath)
													.filter(path -> Files.isDirectory(path))
													.filter(contentPath -> EMAIL.equalsIgnoreCase(contentPath.toFile().getName().trim()))
													.collect(Collectors.toList());
								}
								catch (IOException e)
								{
									e.printStackTrace();
								}
								return emailsForConcepts;
							})
							.flatMap(Collection::stream)
							.map(emailFolder  -> {
								List<Path> templates = Lists.newArrayList();
								try
								{
									templates =
											Files
													.list(emailFolder)
													.collect(Collectors.toList());
								}
								catch (IOException e)
								{
									e.printStackTrace();
								}
								return templates;
							})

							.flatMap(Collection::stream)
							.map(emailTemplate -> {
								List<String> lines = Lists.newArrayList();
								try
								{
									lines = Files.readAllLines(emailTemplate, StandardCharsets.UTF_8);
								}
								catch (IOException e)
								{
									e.printStackTrace();
								}
								return lines;
							})
							.flatMap(Collection::stream)
							.map(line -> line.contains(STAGED) ? line.replaceAll(STAGED, ONLINE) : line)
							.map(line -> Pattern.compile(Pattern.quote("validation"), Pattern.CASE_INSENSITIVE).matcher(line).find() ? "#" + line : line)
							.collect(Collectors.toList());
		}
		if(CollectionUtils.isEmpty(allEmailLines))
			throw new RuntimeException("Nothing to copy....");
		Files.write(Paths.get(outputImpex + "/consolidatedemail.impex"), allEmailLines, StandardCharsets.UTF_8);
	}
}
