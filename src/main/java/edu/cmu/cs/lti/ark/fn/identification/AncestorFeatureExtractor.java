package edu.cmu.cs.lti.ark.fn.identification;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Iterables;
import com.google.common.collect.Maps;
import edu.cmu.cs.lti.ark.fn.data.prep.formats.Sentence;
import edu.cmu.cs.lti.ark.util.ds.map.IntCounter;

import java.io.IOException;
import java.util.Map;

/**
 * @author sthomson@cs.cmu.edu
 */
public class AncestorFeatureExtractor extends BasicFeatureExtractor {

	private final FrameAncestors ancestors;

	public AncestorFeatureExtractor(FrameAncestors ancestors) {
		this.ancestors = ancestors;
	}

	public static AncestorFeatureExtractor load() {
		try {
			return new AncestorFeatureExtractor(FrameAncestors.load());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Map<String, Map<String, Double>> extractFeaturesByName(Iterable<String> frameNames,
																  int[] targetTokenIdxs,
																  Sentence sentence) {
		final IntCounter<String> baseFeatures = getBaseFeatures(targetTokenIdxs, sentence);
		final Map<String, Map<String, Double>> results = Maps.newHashMap();
		// conjoin base features with frame and ancestors
		for (String frame : frameNames) {
			final Iterable<String> frameAndAncestors =
					Iterables.concat(ImmutableSet.of(frame), ancestors.getAncestors(frame));
			final Map<String, Double> featuresForFrame = Maps.newHashMap();
			for (String feature : baseFeatures.keySet()) {
				for (String ancestor : frameAndAncestors) {
					final String frameFtr = "f:" + ancestor;
					featuresForFrame.put(
							SPACE.join(frameFtr, feature),
							baseFeatures.get(feature).doubleValue()
					);
				}
			}
			results.put(frame, featuresForFrame);
		}
		return results;
	}
}
