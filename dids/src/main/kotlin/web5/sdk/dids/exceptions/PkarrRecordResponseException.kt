package web5.sdk.dids.exceptions

/**
 * Pkarr record response exception.
 *
 * @param message the exception message detailing the error
 */
public class PkarrRecordResponseException(message: String) : RuntimeException(message)

/**
 * Did resolution exception.
 *
 * @param message the exception message detailing the error
 */
public class DidResolutionException(message: String) : RuntimeException(message)
