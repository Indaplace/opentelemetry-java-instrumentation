/*
 * Copyright The OpenTelemetry Authors
 * SPDX-License-Identifier: Apache-2.0
 */

package io.opentelemetry.instrumentation.spring.web;

import io.opentelemetry.instrumentation.api.instrumenter.net.NetServerAttributesGetter;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import javax.annotation.Nullable;
import org.springframework.http.HttpRequest;

final class SpringWebNetAttributesGetter implements NetServerAttributesGetter<HttpRequest> {
  @Override
  public String transport(HttpRequest httpRequest) {
    return SemanticAttributes.NetTransportValues.IP_TCP;
  }

  @Override
  @Nullable
  public String peerName(HttpRequest httpRequest) {
    return httpRequest.getURI().getHost();
  }

  @Override
  public Integer peerPort(HttpRequest httpRequest) {
    return httpRequest.getURI().getPort();
  }

  @Override
  @Nullable
  public String peerIp(HttpRequest httpRequest) {
    return null;
  }
}