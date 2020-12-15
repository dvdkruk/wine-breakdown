export default async function fetchBreakdown(lotCode, breakdownType) {
    const response = await fetch(`/api/breakdown/${breakdownType}/${lotCode}`);
    return await response.json();
}
